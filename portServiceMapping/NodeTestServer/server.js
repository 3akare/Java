const express = require("express")
const app = express();
const PORT = 8000;

app.get("/", (req, res) => {
    return res.json({ "testApp": `Live on port${PORT}` })
})
app.listen(PORT, () => {
    console.log(`Listening on port ${PORT}`);
})