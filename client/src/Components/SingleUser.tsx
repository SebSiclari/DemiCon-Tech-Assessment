import React from 'react'
import {User} from '../types/User'

interface userProps {
  user:User
}

export const SingleUser = ({user}:userProps) => {
  const {name, email, gender} = user

  return (
    <div id="singleUser">
    <p>Name: {name}</p>
    <p>Email: {email}</p>
    <p>Gender: {gender}</p>
    </div>
  )
}
