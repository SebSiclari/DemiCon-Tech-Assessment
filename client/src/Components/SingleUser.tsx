import React from "react";
import { User } from "../types/User";

interface userProps {
  user: User;
}

export const SingleUser = ({ user }: userProps) => {
  const { name, email, gender } = user;

  return (<>
    <ul id="singleUser">
      <li>Name: {name}</li> <br></br>
      <li>Email: {email}</li><br></br>
      <li>Gender: {gender}</li>
    </ul>
    <br></br>
    </>
  );
};
