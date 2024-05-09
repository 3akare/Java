import AuthContent from "./components/AuthContent"

function App() {

  return (
    <div>
      Header
      <AuthContent></AuthContent>
      <div className="grid grid-col-2">
      <label htmlFor="login" className="sr-only">login</label>
        <input type="text" name="login" placeholder="login"  className="border-2 w-36 border-black"/>
        <label htmlFor="signup" className="sr-only">Signup</label>
        <input type="text" name="signup" placeholder="signup" className="border-2 w-36 border-black" />
      </div>
    </div>
  )
}

export default App
