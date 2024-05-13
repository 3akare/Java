import axios from "axios";
import { useEffect, useState } from "react";
const BASE_URL = "http://localhost:8080/api/v1/port";

function App() {
  const [data, setData] = useState([]);
  const [refresh, setRefresh] = useState(false);
  const [associateService, setAssociateService] = useState("");
  const [serviceNumber, setServiceNumber] = useState("");

  useEffect(() => {
    axios.get(BASE_URL).then((res) => setData(res.data));
  }, [refresh]);


  const DELETE = (servicePortNumber) => {
    axios
      .delete(`${BASE_URL}?servicePortNumber=${servicePortNumber}`)
      .then((res) => console.log(res));

    setRefresh((value) => !value);
  };



  return (
    <section className="container mx-aut0 max-w-7xl flex flex-col gap-12">
      <section className="flex flex-row items-center justify-between h-16 px-8">
        <img src="/remita_orange_new_logo.svg" alt="remita logo" className="h-8" />
        {/* <button>Add New Port</button> */}
        <DialogDemo associateService={associateService} serviceNumber={serviceNumber} setAssociateService={setAssociateService} setServiceNumber={setServiceNumber} setRefresh={setRefresh}></DialogDemo>
      </section>
      <section className="container mx-auto max-w-6xl">
        <TableDemo data={data}></TableDemo>
      </section>
    </section>
  );
}

export default App;

import {
  Table,
  TableBody,
  TableCaption,
  TableCell,
  TableHead,
  TableHeader,
  TableRow,
} from "@/components/ui/table";

export function TableDemo({ data }) {
  return (
    <Table>
      <TableCaption>Port Status</TableCaption>
      <TableHeader>
        <TableRow>
          <TableHead className="w-[10px]">MappingId</TableHead>
          <TableHead className="w-full">Service Description</TableHead>
          <TableHead className="w-[10px]">Status</TableHead>
          <TableHead className="text-right w-fit">Port Number</TableHead>
          <TableHead className="text-right w-[25px]"></TableHead>
        </TableRow>
      </TableHeader>
      <TableBody>
        {data.map((item) => (
          <TableRow key={item.servicePortNumber}>
            <TableCell className="font-medium">{item.mappingId}</TableCell>
            <TableCell>{item.associateService}</TableCell>
            <TableCell className="flex justify-center items-center"><div className="size-4 bg-green-500 rounded-full"></div></TableCell>

            <TableCell className="text-right">{item.servicePortNumber}</TableCell>
            <TableCell className="flex gap-[10px]">
              <div className="size-5 bg-red-600 "></div>
              <div className="size-5 bg-purple-600 "></div>
            </TableCell>
          </TableRow>
        ))}
      </TableBody>
    </Table>
  );
}

import { Button } from "@/components/ui/button"
import {
  Dialog,
  DialogContent,
  DialogDescription,
  DialogFooter,
  DialogHeader,
  DialogTitle,
  DialogTrigger,
} from "@/components/ui/dialog"
import { Input } from "@/components/ui/input"
import { Label } from "@/components/ui/label"

export function DialogDemo({ associateService, serviceNumber,setAssociateService, setServiceNumber, setRefresh  }) {
  const POST = () => {
    axios
      .post(BASE_URL, {
        associateService: associateService,
        servicePortNumber: serviceNumber,
      })
      .then((response) => {
        setServiceNumber(0);
        setAssociateService("");
        setRefresh((value) => !value);
      });
  };
  const serviceTyping = (event) => {
    setAssociateService(event.target.value);
    console.log(associateService)
  };

  const numberTyping = (event) => {
    setServiceNumber(parseInt(event.target.value));
  };

  return (
    <Dialog>
      <DialogTrigger asChild>
        <Button variant="outline">Add Port</Button>
      </DialogTrigger>
      <DialogContent className="sm:max-w-[425px]">
        <DialogHeader>
          <DialogTitle>Add Port</DialogTitle>
          <DialogDescription>
            Add a port and its service description
          </DialogDescription>
        </DialogHeader>
        <div className="grid gap-4 py-4">
          <div className="grid grid-cols-4 items-center gap-4">
            <Label htmlFor="description" className="text-right">
              Description
            </Label>
            <Input
              id="description"
              placeholder="Enter Description"
              value={associateService}
              onChange={serviceTyping}
              className="col-span-3"
            />
            <Label htmlFor="portnumber" className="text-right">
              Port
            </Label>
            <Input
              id="username"
              placeholder="0 - 65,535"
              value={serviceNumber}
              onChange={numberTyping}
              className="col-span-3"
            />
          </div>
        </div>
        <DialogFooter>
          <Button type="submit" onClick={POST}>add</Button>
        </DialogFooter>
      </DialogContent>
    </Dialog>
  )
}
