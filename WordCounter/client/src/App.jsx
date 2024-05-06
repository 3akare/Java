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
  const [received, setReceived] = useState({
    characters: 0,
    words: 0,
    whitespaces: 0,
    paragraph:0,
    pages: 0,
    sentences: 0,
    writing: 0
  });

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
    <header className="container mx-auto max-w-5xl p-2 h-12 w-full flex items-center justify-start font-bold font-sans">Counter for words</header>
    <main className="container mx-auto max-w-5xl p-2 h-fit w-full flex flex-col gap-8 bg-white rounded-md items-center justify-center divide-y">
      <div className="grid grid-cols-4 gap-12">
        <div className="flex items-center justify-center flex-col w-20 h-20 p-2">
          <h1 className="text-sm">Characters</h1>
          <h2 className="text-5xl font-bold">{received.characters}</h2>
          {/* Characters */}
        </div>
         <div className="flex items-center justify-center flex-col w-20 h-20 p-2">
          <h1 className="text-sm">Words</h1>
          <h2 className="text-5xl font-bold">{received.words}</h2>
          {/* Characters */}
          </div>
           <div className="flex items-center justify-center flex-col w-20 h-20 p-2">
          <h1 className="text-sm" >Whitespaces</h1>
          <h2 className="text-5xl font-bold">{received.whitespaces}</h2>
          {/* Characters */}
        </div>
         <div className="flex items-center justify-center flex-col w-20 h-20 p-2">
          <h1 className="text-sm">Paragraphs</h1>
          <h2 className="text-5xl font-bold">{received.paragraph}</h2>
          {/* Characters */}
        </div>
        
      </div>
      <textarea type="text" value={text} onChange={handleTyping} className="w-full h-96 indent-2 pt-2 outline-none resize-none" placeholder="Write here..." />
      <section className="w-full grid grid-cols-3 h-12 gap-12 self-center place-items-center">
        <h1 className="font-semibold">Pages: <span className="font-normal">{received.pages}</span></h1>
        <h1 className="font-semibold">Writing: <span className="font-normal">{received.writing} mins</span></h1>
        <h1 className="font-semibold">Sentences: <span className="font-normal">{received.sentences}</span></h1>
      </section>
    </main>
    </>
  );
};
export default App;
