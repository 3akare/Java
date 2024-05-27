import path from "path"
import react from "@vitejs/plugin-react-swc"
import { defineConfig } from "vite"

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [react()],
  preview: {
    port: 3000,
    strictPort: true
  },
  server: {
    port: 5173,
    strictPort: 5173,
    host: true,
    origin: "http://0.0.0.0:5173"
  },
  resolve: {
    alias: {
      "@": path.resolve(__dirname, "./src"),
    },
  },
})
