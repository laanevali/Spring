import React, {useRef, useState} from 'react'

function Addproduct() {
  const [message, setMessage] = useState("Lisa toode!");
  const nameRef = useRef();
  const priceRef = useRef();
  const imageRef = useRef();
  const categoryRef = useRef();
  const stockRef = useRef();
  const url = "https://dummyjson.com/products";

  const add = () => {
    if (nameRef.current.value === "") {
      setMessage("Tühja nimetusega toodet lisada ei saa!");
      return;
    } 
      
    setMessage("Toode lisatud: " + nameRef.current.value);

    const newProduct = {
      "name": nameRef.current.value,
      "price": priceRef.current.value,
      "image": imageRef.current.value,
      "category": categoryRef.current.value,
      "stock": stockRef.current.value,
      // "rating": 0
    }
    
    fetch(url, 
      {
        "method": "POST", 
        "body": JSON.stringify(newProduct), 
        "headers": {"Content-Type": "application/json"} // react ütleb et json.stringify, saad kontrollida urli kaudu postman-is
      }).then(res => res.json())
        .then(body => console.log(body)); 
  }

  return (
    <div>
        <div>{message}</div>
        <label>Uue toote nimi</label> <br />
        <input ref={nameRef} type="text" /> <br />
        <label>Uue toote hind</label> <br />
        <input ref={priceRef} type="text" /> <br />
        <label>Uue toote pilt</label> <br />
        <input ref={imageRef} type="text" /> <br />
        <label>Uue toote kategooria</label> <br />
        <input ref={categoryRef} type="text" /> <br />
        <label>Uue toote kogus</label> <br />
        <input ref={stockRef} type="text" /> <br />
        <button onClick={add}>Lisa</button> <br />
    </div>
  )
}

export default Addproduct