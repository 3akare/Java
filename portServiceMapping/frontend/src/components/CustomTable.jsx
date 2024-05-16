import { Table, TableBody, TableCaption, TableCell, TableHead, TableHeader, TableRow } from "@/components/ui/table"
import DeletePortMappingButton from "./DeletePortMappingButton"
import UpdatePortMappingButton from "./UpdatePortMappingButton"
import PaginationBody from "./PaginationBody";
import { useState } from "react";


function CustomTable({ caption, portMappingData }) {
    const rowsPerPage = 7;
    const [startIndex, setStartIndex] = useState(0);
    const [endIndex, setEndIndex] = useState(rowsPerPage);

    const display = portMappingData.length === 0 ? <div className="text-center text-xl">Nothing to see!</div> : <>
        <Table >
            <TableCaption>
                <PaginationBody className="text-black" startIndex={startIndex} endIndex={endIndex} setStartIndex={setStartIndex} setEndIndex={setEndIndex} rowsPerPage={rowsPerPage} size={portMappingData.length}></PaginationBody>
                {caption}
            </TableCaption>
            <TableHeader>
                <TableRow>
                    <TableHead className="w-fit text-left">IP Address</TableHead>
                    <TableHead className="w-fit text-left">Port</TableHead>
                    <TableHead className="w-1/2 text-left">Service</TableHead>
                    <TableHead className="w-fit text-center">Java Version</TableHead>
                    <TableHead className="w-fit text-left">Status</TableHead>
                    <TableHead className="w-fit text-left">Actions</TableHead>
                </TableRow>
            </TableHeader>
            <TableBody>
                {portMappingData.slice(startIndex, endIndex).map((portMappingitem) => {
                    return (
                        <TableRow key={`${portMappingitem.serviceIpAddress}${portMappingitem.servicePortNumber}`} className="font-medium">
                            <TableCell>{portMappingitem.serviceIpAddress}</TableCell>
                            <TableCell>{portMappingitem.servicePortNumber}</TableCell>
                            <TableCell>{portMappingitem.associateService}</TableCell>
                            <TableCell className="flex items-center justify-center text-center">{portMappingitem.javaVersion}</TableCell>
                            <TableCell>
                                <div className="flex items-center justify-center">
                                    {
                                        portMappingitem.serviceStatus === "ACTIVE" ? <div className="bg-green-500 size-4 rounded-full"></div> : <div className="bg-red-500 size-4 rounded-full"></div>
                                    }
                                </div></TableCell>
                            <TableCell className="flex gap-3 items-center justify-center">
                                <UpdatePortMappingButton servicePortNumber={portMappingitem.servicePortNumber} serviceIpAddress={portMappingitem.serviceIpAddress}></UpdatePortMappingButton>
                                <DeletePortMappingButton servicePortNumber={portMappingitem.servicePortNumber} serviceIpAddress={portMappingitem.serviceIpAddress}></DeletePortMappingButton>
                            </TableCell>
                        </TableRow>
                    )
                })}
            </TableBody>
        </Table>
    </>
    return (display)
}

export default CustomTable;