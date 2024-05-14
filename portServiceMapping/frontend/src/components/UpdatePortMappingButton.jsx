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
import { Edit2Icon, Trash2Icon } from "lucide-react"

import { Input } from "@/components/ui/input"
import { Label } from "@/components/ui/label"
import { Textarea } from "./ui/textarea"
import { useState, useEffect } from "react"
import { useRefresh } from "@/lib/zustand"
import PortInput from "./PortInput"

function UpdatePortMappingButton({ servicePortNumber, serviceIpAddress }) {
    const BASE_URL = "http://localhost:8080/api/v1/port";
    const [newIpAddress, setnewIpAddress] = useState("");
    const [newServicePortNumber, setServiceNumber] = useState("");
    const [description, setDescription] = useState("");
    const [javaVersion, setJavaVersion] = useState("");

    const refreshTable = useRefresh((state) => state.refreshTable);

    const handleChangingnewIpAddress = (event) => {
        setnewIpAddress(event.target.value.trim());
    }

    const handleChangingDescription = (event) => {
        setDescription(event.target.value)
    }

    const handleChangingJavaVersion = (event) => {
        setJavaVersion(event.target.value);
    }
    const UPDATE = () => {
        axios.put(`${BASE_URL}?servicePortNumber=${servicePortNumber}&serviceIpAddress=${serviceIpAddress}`, {
            serviceIpAddress: newIpAddress,
            associateService: description,
            servicePortNumber: parseInt(newServicePortNumber),
            javaVersion: javaVersion
        })
            .then((response) => {
                setDescription("");
                setServiceNumber("")
                setJavaVersion("")
                setnewIpAddress("")
                refreshTable();
            });
    };

    useEffect(() => {
        setnewIpAddress(serviceIpAddress);
        setServiceNumber(servicePortNumber)
    }, [])
    
    return (
        <Dialog>
            <DialogTrigger asChild>
                <Button variant="outline" size="icon"><Edit2Icon size={16} /></Button>
            </DialogTrigger>
            <DialogContent className="sm:max-w-[425px]">
                <DialogHeader>
                    <DialogTitle>Update {serviceIpAddress}:{servicePortNumber}</DialogTitle>
                    <DialogDescription>
                        Update IP addresses and ports for monitoring network connections
                    </DialogDescription>
                </DialogHeader>
                <div className="grid gap-4 py-4">
                    <div className="grid grid-cols-4 items-center gap-4">
                        <Label htmlFor="newIpaddress" className="text-left">
                            IP Address
                        </Label>
                        <Input
                            id="newIpaddress"
                            placeholder="Enter IP Address"
                            value={newIpAddress}
                            onChange={handleChangingnewIpAddress}
                            className="col-span-3 !outline-none"
                        />
                        <div className="col-span-4 grid grid-cols-2">
                            <Label htmlFor="portnumber" className="text-left">
                                Port
                            </Label>
                            <PortInput id="port" value={newServicePortNumber} handleChange={setServiceNumber}></PortInput>
                        </div>
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
                        <Button type="submit" className="w-full" onClick={UPDATE}>Update Mapping</Button>
                    </DialogTrigger>
                </DialogFooter>
            </DialogContent>
        </Dialog>
    )
}

export default UpdatePortMappingButton;
