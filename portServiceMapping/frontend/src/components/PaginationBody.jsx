import {
    Pagination,
    PaginationContent,
    PaginationItem,
    PaginationNext,
    PaginationPrevious,
} from "@/components/ui/pagination"

const PaginationBody = ({ startIndex, endIndex, setEndIndex, setStartIndex, rowsPerPage, size }) => {
    return (
        <Pagination>
            <PaginationContent>
                <PaginationItem>
                    <PaginationPrevious className={startIndex === 0 ? "pointer-events-none opacity-50" : "cursor-pointer"}
                        onClick={() => {
                            setStartIndex(startIndex - rowsPerPage);
                            setEndIndex(endIndex - rowsPerPage);
                        }}
                    />
                </PaginationItem>
                <PaginationItem>
                    <PaginationNext className={endIndex >= size ? "pointer-events-none opacity-50" : "cursor-pointer"}
                        onClick={() => {
                            setStartIndex(startIndex + rowsPerPage);
                            setEndIndex(endIndex + rowsPerPage);
                        }}>
                    </PaginationNext>
                </PaginationItem>
            </PaginationContent>
        </Pagination>
    )
}

export default PaginationBody;