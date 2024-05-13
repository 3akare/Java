import { Table, TableBody, TableCaption, TableCell, TableHead, TableHeader, TableFooter, TableRow } from "@/components/ui/table"

function CustomTable({ caption, portMappingData }) {
    const display = portMappingData[0] > 0 ? <div className="text-center text-xl">Nothing to see!</div> : <Table>
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
                    <TableRow key={portMappingitem.servicePortNumber} className="font-medium">
                        <TableCell>{portMappingitem.serviceIpAddress}</TableCell>
                        <TableCell>{portMappingitem.servicePortNumber}</TableCell>
                        <TableCell>{portMappingitem.associateService}</TableCell>
                        <TableCell>{portMappingitem.serviceStatus}</TableCell>
                        <TableCell>
                            ff
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