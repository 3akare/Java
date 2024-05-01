import { useState } from "react";

import {
  useStompClient,
  useSubscription,
} from "react-stomp-hooks";

function ChildComponent() {
  const [message, setMessage] = useState("");
  useSubscription("/topic/reply", (message) => {
    setMessage(message.body);
  });
  return <div> Message from broker is {message}</div>;
}

function PublishComponent() {
  //Will push message to all users that have subscribed to /topic/reply
  const stompClient = useStompClient();
  function publishMessage() {
    if (stompClient) {
      stompClient.publish({
        destination: "/app/broadcast",
        body: "Hello world",
      });
    }
  }

  return <div onClick={publishMessage}>Send Message</div>;
}
