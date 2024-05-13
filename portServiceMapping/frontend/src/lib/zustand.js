import {create} from "zustand"

export const useRefresh = create((set) => {
    return {
        refresh: false,
        refreshTable: () => set((state) => ({ refresh: !state.refresh })),
    };
});