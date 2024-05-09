import { useState } from "react"
import { request } from "../axios_helper"

const AuthContent = () => {
    const [data, setData] = useState([]);

    async function GET() {
        const res = await request("GET", "/messages", {});
        setData(res.data);
    }

    return (
        <>
            <button onClick={GET}>AuthContent</button>
            <div>{data.map((item, index) => {
                return <p key={index}>{item}</p>
            })}</div>
        </>
    )
}

export default AuthContent;