import { Table, TableBody, TableCaption, TableCell, TableHead, TableHeader, TableFooter, TableRow } from "@/components/ui/table"
import DeletePortMappingButton from "./DeletePortMappingButton"
import UpdatePortMappingButton from "./UpdatePortMappingButton"

function CustomTable({ caption, portMappingData }) {
    const display = portMappingData.length === 0 ? <div className="text-center text-xl">Nothing to see!</div> : <Table>
        <TableCaption>{caption}</TableCaption>
        <TableHeader>
            <TableRow>
                <TableHead className="w-fit text-left">IP Address</TableHead>
                <TableHead className="w-fit text-left">Port</TableHead>
                <TableHead className="w-1/2 text-left">Service</TableHead>
                <TableHead className="w-fit text-left">Status</TableHead>
                <TableHead className="w-fit text-left">Actions</TableHead>
            </TableRow>
        </TableHeader>
        <TableBody>
            {portMappingData.map((portMappingitem) => {
                return (
                    <TableRow key={`${portMappingitem.serviceIpAddress}${portMappingitem.servicePortNumber}`} className="font-medium">
                        <TableCell>{portMappingitem.serviceIpAddress}</TableCell>
                        <TableCell>{portMappingitem.servicePortNumber}</TableCell>
                        <TableCell>{portMappingitem.associateService}</TableCell>
                        <TableCell>
                            <div className="flex items-center justify-center">
                                {
                                    portMappingitem.serviceStatus === "ACTIVE" ? <div className="bg-green-500 size-4 rounded-full"></div> : <div className="bg-red-500 size-4 rounded-full"></div>
                                }
                            </div></TableCell>
                        <TableCell className="flex gap-3 items-center justify-center">
                            <UpdatePortMappingButton servicePortNumber={portMappingitem.servicePortNumber}></UpdatePortMappingButton>
                            <DeletePortMappingButton servicePortNumber={portMappingitem.servicePortNumber}></DeletePortMappingButton>
                            {/* edit button */}
                            {/* delete button */}
                        </TableCell>
                    </TableRow>
                )
            })}
        </TableBody>
    </Table>
    return (display)
}

export default CustomTable;