import axios from "axios";
import { useEffect, useState } from "react";

function App() {
  const BASE_URL = "http://localhost:8080/api/v1/port";
  const [data, setData] = useState([]);
  const [associateService, setAssociateService] = useState("");
  const [serviceNumber, setServiceNumber] = useState("");

  useEffect(() => {
    axios.get(BASE_URL).then((res) => setData(res.data));
  }, []);

  const POST = (event) => {
    event.preventDefault();
    axios
      .post(BASE_URL, {
        associateService: associateService,
        servicePortNumber: serviceNumber,
      })
      .then((response) => {
        serviceNumber(0);
        setAssociateService("");
        console.log(data);
      });

    window.location.reload();
  };

  const DELETE = (servicePortNumber) => {
    axios
      .delete(`${BASE_URL}?servicePortNumber=${servicePortNumber}`)
      .then((res) => console.log(res));

    window.location.reload();
  };

  const serviceTyping = (event) => {
    setAssociateService(event.target.value);
  };

  const numberTyping = (event) => {
    setServiceNumber(parseInt(event.target.value));
  };

  return (
    <>
      Header <button>hello there</button>
      {data &&
        data.map((item) => {
          return (
            <div key={item.mappingId}>
              {item.mappingId}::{item.associateService}::
              {item.servicePortNumber}{" "}
              <div onClick={() => DELETE(item.servicePortNumber)}>button</div>
            </div>
          );
        })}
      <form onSubmit={POST}>
        <input
          type="text"
          placeholder="message"
          // value={associateService}
          value={associateService}
          onChange={serviceTyping}
        />
        <input
          type="text"
          placeholder="number"
          value={serviceNumber}
          onChange={numberTyping}
        />
        <button>send</button>
      </form>
      <TableDemo></TableDemo>
    </>
  );
}

export default App;

import {
  Table,
  TableBody,
  TableCaption,
  TableCell,
  TableFooter,
  TableHead,
  TableHeader,
  TableRow,
} from "@/components/ui/table";

const invoices = [
  {
    invoice: "INV001",
    paymentStatus: "Paid",
    totalAmount: "$250.00",
    paymentMethod: "Credit Card",
  },
  {
    invoice: "INV002",
    paymentStatus: "Pending",
    totalAmount: "$150.00",
    paymentMethod: "PayPal",
  },
  {
    invoice: "INV003",
    paymentStatus: "Unpaid",
    totalAmount: "$350.00",
    paymentMethod: "Bank Transfer",
  },
  {
    invoice: "INV004",
    paymentStatus: "Paid",
    totalAmount: "$450.00",
    paymentMethod: "Credit Card",
  },
  {
    invoice: "INV005",
    paymentStatus: "Paid",
    totalAmount: "$550.00",
    paymentMethod: "PayPal",
  },
  {
    invoice: "INV006",
    paymentStatus: "Pending",
    totalAmount: "$200.00",
    paymentMethod: "Bank Transfer",
  },
  {
    invoice: "INV007",
    paymentStatus: "Unpaid",
    totalAmount: "$300.00",
    paymentMethod: "Credit Card",
  },
];

export function TableDemo() {
  return (
    <Table>
      <TableCaption>A list of your recent invoices.</TableCaption>
      <TableHeader>
        <TableRow>
          <TableHead className="w-[100px]">Invoice</TableHead>
          <TableHead>Status</TableHead>
          <TableHead>Method</TableHead>
          <TableHead className="text-right">Amount</TableHead>
        </TableRow>
      </TableHeader>
      <TableBody>
        {invoices.map((invoice) => (
          <TableRow key={invoice.invoice}>
            <TableCell className="font-medium">{invoice.invoice}</TableCell>
            <TableCell>{invoice.paymentStatus}</TableCell>
            <TableCell>{invoice.paymentMethod}</TableCell>
            <TableCell className="text-right">{invoice.totalAmount}</TableCell>
          </TableRow>
        ))}
      </TableBody>
      <TableFooter>
        <TableRow>
          <TableCell colSpan={3}>Total</TableCell>
          <TableCell className="text-right">$2,500.00</TableCell>
        </TableRow>
      </TableFooter>
    </Table>
  );
}
