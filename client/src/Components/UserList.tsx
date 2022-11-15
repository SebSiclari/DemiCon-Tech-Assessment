import React, { useState, useEffect } from "react";
import { Country, UserAPI, User } from "../types/User";
import { SingleUser } from "./SingleUser";

interface UserListProps {
  data: UserAPI | undefined;
  country: string;
}

export const UserList = ({ data, country }: UserListProps) => {
  return (
    <div>
      {data?.countries
        .filter((c) => c.name === country)
        .flatMap((c) =>
          c.users.map((u) => <SingleUser key={u.name} user={u} />)
        )}
    </div>
  );
};
