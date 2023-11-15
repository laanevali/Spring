import React, { useState } from 'react'

function HomePage() {
  const[quantity, setQuantity] = useState(6);
  const[message, setMessage]= useState();
  
  const zero = () => {
    setQuantity(0);
    setMessage("Nullituc");
  }

  const decrease = () => {
    setQuantity( quantity -1);
    setMessage("Vähendatud");
  }

  const increase = () => {
    setQuantity(quantity+1);
    setMessage("Suurendatud")
  }

  return (
    <div>
        {quantity !== 0 && <button onClick={zero}>Nulli</button>}
        <br /> <br />
        <button disabled={quantity === 0} onClick={decrease}>-</button>
        <span>{quantity}</span>
        <button onClick={increase}>+</button>
    </div>
  )
}

export default HomePage