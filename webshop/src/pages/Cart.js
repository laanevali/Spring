import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';

function Cart() {
  const [cart, setCart] = useState([{name:"Coca", price:2}, {name:"Fanta", price: 1.5}, {name:"Sprite", price:1.7}]);

  const [parcelMachines, setParcelMachines] = useState([]);

  useEffect(() => {
    fetch("https://www.omniva.ee/locations.json")
      .then(response => response.json())
      .then(body =>{
        const result = body.filter(pm => pm.A0_NAME === "EE")
        setParcelMachines(result)
      })
  }, []);
        

  const remove = (index) => {
    cart.splice(index,1);
    setCart([...cart]);
  }

  const calculateTotalSum = () => {
    let sum = 0;
    cart.forEach(product => sum += product.price);
    return sum;
  }

  return (
    <div>
        {cart.length > 0 && <div>Ostukorvis on kokku: {cart.length} ese(t)</div>}
        <div>{cart.map((product, index) => 
          <div key={product.name}>
            {product.name} - {product.price} €
            <button onClick={() => remove()}>x</button> 
          </div> )}
        </div>
        {cart.length === 0 &&
        <>
          <div>Ostukorv on tühi</div>
          <Link to="/avaleht">
              <button>Lisa tooteid</button>
          </Link>
        </>}
        <div>{calculateTotalSum}</div>

        <select> (//dropdown)
        {parcelMachines.map(pm => <option key={pm.NAME}>{pm.NAME}</option>)}
        </select>
          
    </div>
  )
}

export default Cart