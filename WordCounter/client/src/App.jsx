import { useEffect, useState } from "react";
import {
  StompSessionProvider,
  useStompClient,
  useSubscription,
} from "react-stomp-hooks";

function App() {
  return (
    <StompSessionProvider url={"https://java-1-zxeh.onrender.com/ws-endpoint"}>
      <InputComponent></InputComponent>
    </StompSessionProvider>
  );
}

const InputComponent = () => {
  const [text, setText] = useState("");
  const [received, setReceived] = useState({});
  const stompClient = useStompClient();

  useEffect(()=>{
if (stompClient) {
      stompClient.publish({
        destination: "/app/user-message",
        body: "",
      });
    }
  },[])
  
  useSubscription("/user/queue/reply", (message) => {
    setReceived(JSON.parse(message.body))
    console.log(received)
  });

  const handleTyping = (event) => {
    setText(event.target.value);
    if (stompClient) {
      stompClient.publish({
        destination: "/app/user-message",
        body: `${text}`,
      });
    }
  };
  return (
    <>
      <div>characters: {received.characters}</div>
      <div>words: {received.words}</div>
      <div>whitespaces: {received.whitespaces}</div>
      <div>paragraph: {received.paragraph}</div>
      <div>pages: {received.pages}</div>
      <div>sentences: {received.sentences}</div>
      <div>writing: {received.writing}</div>
      <textarea type="text" value={text} onChange={handleTyping} />
    </>
  );
};
export default App;
