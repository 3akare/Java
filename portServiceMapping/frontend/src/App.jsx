import CustomTable from "./components/CustomTable";
import CreatePortMapping from "./components/CreatePortMapping";
import { useRefresh } from "./lib/zustand";

import axios from "axios";
import { useEffect, useState } from "react";

function App() {
  const BASE_URL = "http://localhost:8080/api/v1/port";
  const refresh = useRefresh((state) => state.refresh);
  const [portMappingData, setPortMappingData] = useState([]);

  useEffect(() => {
    axios.get(BASE_URL).then((res) => setPortMappingData(res.data));
  }, [refresh]);

  return (
    <section className="container mx-auto max-w-7xl flex flex-col gap-12">
      <section className="flex flex-row items-center justify-between h-16 px-8">
        <img src="/remita_orange_new_logo.svg" alt="remita logo" className="h-6" />
        <CreatePortMapping></CreatePortMapping>
      </section>
      <section className="container mx-auto max-w-6xl">
        <CustomTable caption={`last Updated at 18:88`} portMappingData={portMappingData}/>
      </section>
    </section>
  );
}

export default App;