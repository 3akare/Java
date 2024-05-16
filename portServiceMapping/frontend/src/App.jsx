import CustomTable from "./components/CustomTable";
import CreatePortMapping from "./components/CreatePortMapping";
import { useArrayState, useRefresh } from "./lib/zustand";

import axios from "axios";
import { useEffect, useState } from "react";
import SearchBar from "./components/SearchBar";

function App() {
  const BASE_URL = "http://localhost:8080/api/v1/port";
  const refresh = useRefresh((state) => state.refresh);
  const [portMappingData, setPortMappingData] = useState([]);
  const [date, setDate] = useState(`${new Date().getHours()}:${new Date().getMinutes()}`);
  const refreshTable = useRefresh((state) => state.refreshTable);

  // const axios = require('axios');

  // const dummyData = [
  //   {
  //     servicePortNumber: 8080,
  //     associateService: 'Service A',
  //     serviceIpAddress: '192.168.1.100',
  //     javaVersion: '11.0'
  //   },
  //   {
  //     servicePortNumber: 3000,
  //     associateService: 'Service B',
  //     serviceIpAddress: '192.168.1.101',
  //     javaVersion: '14.0'
  //   },
  //   {
  //     servicePortNumber: 4000,
  //     associateService: 'Service C',
  //     serviceIpAddress: '192.168.1.102',
  //     javaVersion: '8.0'
  //   }
  // ];

  // const POST = async (data) => {
  //   try {
  //     const response = await axios.post(BASE_URL, data);
  //     console.log('Success:', response.data);
  //   } catch (error) {
  //     console.error('Error:', error.message);
  //   }
  // }

  // // Function to send dummy data using POST requests
  // const sendDummyData = async () => {
  //   for (let i = 0; i < dummyData.length; i++) {
  //     await POST(dummyData[i]);
  //   }
  // }

  // sendDummyData();


  useEffect(() => {
    axios.get(BASE_URL).then((res) => setPortMappingData(res.data));
  }, [refresh]);

  useEffect(() => {
    const interval = setInterval(() => {
      setDate(`${new Date().getHours()}:${new Date().getMinutes()}`)
      // console.log('++>', portMappingData)
      refreshTable();
    }, 2000);

    return () => clearInterval(interval);
  }, []);


  return (
    <section className="container mx-auto max-w-7xl flex flex-col gap-12">
      <section className="flex flex-row items-center justify-between h-16 px-8">
        <img src="/remita_orange_new_logo.svg" alt="remita logo" className="h-6" />
        <SearchBar portMappingData={portMappingData} />
        <CreatePortMapping />
      </section>
      <section className="container mx-auto max-w-6xl min-h-[658px]">
        <CustomTable caption={`last Updated at ${date}`} portMappingData={portMappingData} />
      </section>
    </section>
  );
}

export default App;