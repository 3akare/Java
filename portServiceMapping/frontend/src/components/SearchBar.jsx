import { useState, useEffect } from "react"
import { Check, Search } from "lucide-react"

import { cn } from "@/lib/utils"
import { Button } from "@/components/ui/button"
import {
    Command,
    CommandEmpty,
    CommandInput,
    CommandItem,
} from "@/components/ui/command"
import {
    Popover,
    PopoverContent,
    PopoverTrigger,
} from "@/components/ui/popover"
import { CommandList } from "cmdk"

export default function SearchBar({ portMappingData }) {
    const [open, setOpen] = useState(false)
    const [value, setValue] = useState("")

    return (
        <Popover open={open} onOpenChange={setOpen}>
            {/* <button onClick={() => console.log(portMappingData)}>dd   </button> */}
            <PopoverTrigger asChild className="">
                <Button
                    variant="outline"
                    role="combobox"
                    aria-expanded={open}
                    className="max-w-[400px] w-2/5 justify-between"
                >
                    {value
                        ? portMappingData.find((framework) => framework.value === value).label
                        : "Search..."}
                    {/* <ChevronsUpDown className="ml-2 h-4 w-4 shrink-0 opacity-50" /> */}
                    <Search className="size-4 ml-2 shrink-0 opacity-50"></Search>

                </Button>
            </PopoverTrigger>
            <PopoverContent className="w-[400px] p-0">
                <Command>
                    <CommandInput placeholder="Search..." />
                    <CommandEmpty>No IP Address found.</CommandEmpty>
                    <CommandList className="max-h-40 overflow-hidden">
                        {portMappingData.map((framework) => (
                            <CommandItem
                                key={framework.serviceIpAddress + framework.servicePortNumber}
                                value={framework.serviceIpAddress + framework.servicePortNumber}
                                onSelect={(currentValue) => {
                                    setValue(currentValue === value ? "" : currentValue)
                                    setOpen(false)
                                }} s
                            >
                                <Check
                                    className={cn(
                                        "mr-2 h-4 w-4",
                                        value === framework.serviceIpAddress ? "opacity-100" : "opacity-0"
                                    )}
                                />
                                <div className="flex items-center w-full justify-between px-2">
                                    <div className="">
                                        {framework.serviceIpAddress}
                                    </div>

                                    <div className={framework.serviceStatus === "ACTIVE" ? "size-2 rounded-md bg-green-500" : "size-2 rounded-md bg-red-500"}></div>
                                </div>

                            </CommandItem>
                        ))}
                    </CommandList>
                </Command>
            </PopoverContent>
        </Popover>
    )
}
