import { useState } from "react";
import {
  StompSessionProvider,
  useStompClient,
  useSubscription,
} from "react-stomp-hooks";

function App() {
  return (
    <StompSessionProvider url={"http://localhost:8080/ws-endpoint"}>
      <InputComponent></InputComponent>
    </StompSessionProvider>
  );
}

const InputComponent = () => {
  const [text, setText] = useState("");
  const [received, setReceived] = useState("");
  const stompClient = useStompClient();

  useSubscription("/queue/reply", (message) => {
    setReceived(message.body);
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
      <div>Message: {received}</div>
      <input type="text" value={text} onChange={handleTyping} />
    </>
  );
};
export default App;
