import axios from "axios";
import {
    AlertDialog,
    AlertDialogAction,
    AlertDialogCancel,
    AlertDialogContent,
    AlertDialogDescription,
    AlertDialogFooter,
    AlertDialogHeader,
    AlertDialogTitle,
    AlertDialogTrigger,
} from "@/components/ui/alert-dialog"
import { Button } from "@/components/ui/button"
import { useRefresh } from "@/lib/zustand";
import { Trash2Icon } from "lucide-react"
import { useToast } from "./ui/use-toast";

function DeletePortMappingButton({ servicePortNumber, serviceIpAddress }) {
    const BASE_URL = "http://localhost:8080/api/v1/port";
    const refreshTable = useRefresh((state) => state.refreshTable)
    const { toast } = useToast();

    const DELETE = () => {
        axios
            .delete(`${BASE_URL}?servicePortNumber=${servicePortNumber}&serviceIpAddress=${serviceIpAddress}`)
            .then((res) => {
                refreshTable();
                toast({
                    title: "Deleted!"
                })
            });
    };

    return (
        <AlertDialog>
            <AlertDialogTrigger asChild>
                <Button variant="destructive" size="icon">
                    <Trash2Icon size={16} />
                </Button>
            </AlertDialogTrigger>
            <AlertDialogContent>
                <AlertDialogHeader>
                    <AlertDialogTitle>Are you absolutely sure?</AlertDialogTitle>
                    <AlertDialogDescription>
                        This action cannot be undone. This will permanently delete your
                        port Mapping and remove the data from our servers.
                    </AlertDialogDescription>
                </AlertDialogHeader>
                <AlertDialogFooter>
                    <AlertDialogCancel>Cancel</AlertDialogCancel>
                    <AlertDialogAction className="bg-destructive" onClick={() => DELETE()}>Delete</AlertDialogAction>
                </AlertDialogFooter>
            </AlertDialogContent>
        </AlertDialog>
    )
}

export default DeletePortMappingButton;