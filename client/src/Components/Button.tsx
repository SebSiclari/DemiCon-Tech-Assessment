import React from 'react'

export const Button =()=>{

  function working(){
    alert('its working!')
  }
  return (
    <button onClick={working}> Click Me!</button>
  )
}

export default Button