import React, { useState, useEffect } from "react";
import { Country, UserAPI, User } from "../types/User";
import { SingleUser } from "./SingleUser";

interface UserListProps {
  data: UserAPI | undefined;
  country: string;
}

export const UserList = ({ data, country }: UserListProps) => {
  const [userList, setUserList] = useState<User[]>([]);

  useEffect(() => {
    const newUserList = data?.countries.find(
      (ct: Country) => ct.name === country
    );
    if (newUserList) {
      setUserList(newUserList.users);
    }
  }, [country]);
  console.log( 'this is userList', userList);

  return (<div>{userList.map((user:User)=> <SingleUser key={user.name} user={user}/>)}</div>);
};
