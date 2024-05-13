import CustomTable from "./components/CustomTable";
import CreatePortMapping from "./components/CreatePortMapping";
import { useRefresh } from "./lib/zustand";

import axios from "axios";
import { useEffect, useState } from "react";

function App() {
  const BASE_URL = "http://localhost:8080/api/v1/port";
  const refresh = useRefresh((state) => state.refresh);
  // const show = useStore((state) => state.show)
  // const refresh = useStore((state) => state.refresh)
  // const refresh = useStore((state) => state.refresh)
  // const [data, setData] = useState([]);


  // const [refresh, setRefresh] = useState(false);
  const [associateService, setAssociateService] = useState("");
  const [serviceNumber, setServiceNumber] = useState("");

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




// export function DialogDemo({ associateService, serviceNumber, setAssociateService, setServiceNumber, setRefresh }) {
//   const POST = () => {
//     axios
//       .post(BASE_URL, {
//         associateService: associateService,
//         servicePortNumber: serviceNumber,
//       })
//       .then((response) => {
//         setServiceNumber(0);
//         setAssociateService("");
//         setRefresh((value) => !value);
//       });
//   };
//   const serviceTyping = (event) => {
//     setAssociateService(event.target.value);
//   };

//   const numberTyping = (event) => {
//     setServiceNumber(parseInt(event.target.value));
//   };

//   return (
    
//   )
// }


// export function DialogDemoB({ serviceNumber, setRefresh }) {
//   const [das, setdas] = useState("");
//   const [dasN, setDasN] = useState("");
//   const UPDATE = () => {
//     axios.put(`${BASE_URL}?servicePortNumber=${serviceNumber}`, {
//       associateService: das,
//       servicePortNumber: parseInt(dasN)
//     })
//       .then((response) => {
//         setDasN("");
//         setdas("");
//         setRefresh((value) => !value);
//       });
//   };
//   const serviceTypinga = (event) => {
//     setdas(event.target.value);
//   };

//   const numberTypinga = (event) => {
//     setDasN(parseInt(event.target.value));
//   };

//   return (
//     <Dialog>
//       <DialogTrigger asChild>
//         <Button variant="outline">update</Button>
//       </DialogTrigger>
//       <DialogContent className="sm:max-w-[425px]">
//         <DialogHeader>
//           <DialogTitle>Update Port</DialogTitle>
//           <DialogDescription>
//             {`update a port ${serviceNumber} and its service description`}
//           </DialogDescription>
//         </DialogHeader>
//         <div className="grid gap-4 py-4">
//           <div className="grid grid-cols-4 items-center gap-4">
//             <Label htmlFor="description" className="text-right">
//               Description
//             </Label>
//             <Input
//               id="description"
//               placeholder="Enter Description"
//               // value={associateService}
//               // value={associateService}
//               onChange={serviceTypinga}
//               className="col-span-3"
//             />
//             <Label htmlFor="portnumber" className="text-right">
//               Port
//             </Label>
//             <Input
//               id="username"
//               placeholder="0 - 65,535"
//               // value={serviceNumber}
//               onChange={numberTypinga}
//               className="col-span-3"
//             />
//           </div>
//         </div>
//         <DialogFooter>
//           <Button type="submit" onClick={UPDATE}>update</Button>
//         </DialogFooter>
//       </DialogContent>
//     </Dialog>
//   )
// }
