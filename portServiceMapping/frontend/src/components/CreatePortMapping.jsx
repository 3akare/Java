import axios from "axios"
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
import { Textarea } from "./ui/textarea"
import { useState } from "react"
import { useRefresh } from "@/lib/zustand"

function CreatePortMapping() {
    const BASE_URL = "http://localhost:8080/api/v1/port";
    const [ipAddress, setIpAddress] = useState("");
    const [servicePortNumber, setServiceNumber] = useState("");
    const [description, setDescription] = useState("");
    const [javaVersion, setJavaVersion] = useState("");

    const refreshTable = useRefresh((state) => state.refreshTable);

    const handleChangingIpAddress = (event) => {
        setIpAddress(event.target.value.trim());
    }

    const handleChangingServicePortNumber = (event) => {
        setServiceNumber(event.target.value.trim());
    }

    const handleChangingDescription = (event) => {
        setDescription(event.target.value)
    }

    const handleChangingJavaVersion = (event) => {
        setJavaVersion(event.target.value);
    }
    const POST = () => {
        axios.post(BASE_URL, {
            servicePortNumber: servicePortNumber,
            associateService: description,
            serviceIpAddress: ipAddress,
            javaVersion: javaVersion
        }).then(() => {
            setIpAddress("");
            setServiceNumber("");
            setDescription("");
            setJavaVersion("");
            refreshTable();
        })
    }

    return (
        <Dialog>
            <DialogTrigger asChild>
                <Button variant="outline">Add</Button>
            </DialogTrigger>
            <DialogContent className="sm:max-w-[425px]">
                <DialogHeader>
                    <DialogTitle>Create New Port Mapping</DialogTitle>
                    <DialogDescription>
                        Track IP addresses and ports for monitoring network connections
                    </DialogDescription>
                </DialogHeader>
                <div className="grid gap-4 py-4">
                    <div className="grid grid-cols-4 items-center gap-4">
                        <Label htmlFor="ipaddress" className="text-left">
                            IP Address
                        </Label>
                        <Input
                            id="ipaddress"
                            placeholder="Enter IP Address"
                            value={ipAddress}
                            onChange={handleChangingIpAddress}
                            className="col-span-3 !outline-none"
                        />
                        <Label htmlFor="portnumber" className="text-left">
                            Port
                        </Label>
                        <Input
                            id="port"
                            placeholder="Enter port number"
                            value={servicePortNumber}
                            onChange={handleChangingServicePortNumber}
                            className="col-span-3"
                        />
                        <Label htmlFor="javaversion" className="text-left">
                            Java Version
                        </Label>
                        <Input
                            id="javaversion"
                            placeholder="Enter Java Version"
                            value={javaVersion}
                            onChange={handleChangingJavaVersion}
                            className="col-span-3"
                        />
                        <Label htmlFor="description" className="text-left">
                            Description
                        </Label>
                        <Textarea id="description"
                            placeholder="Enter service description"
                            value={description}
                            onChange={handleChangingDescription}
                            className="col-span-3 resize-none"
                        />
                    </div>
                </div>
                <DialogFooter>
                    <DialogTrigger asChild>
                        <Button type="submit" className="w-full" onClick={POST}>Create Mapping</Button>
                    </DialogTrigger>
                </DialogFooter>
            </DialogContent>
        </Dialog>
    )
}

export default CreatePortMapping