import React from 'react'
import {User} from '../types/User'

interface userProps {
  user:User
}

export const SingleUser = ({user}:userProps) => {
  const {name, email, gender} = user

  return (
    <div><p>Name: {name}</p><br></br>
    <p>Email: {email}</p> <br></br>
    <p>Gender: {gender}</p><br></br>
    </div>
  )
}
