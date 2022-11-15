import { SingleUser } from "./SingleUser";
import { DataResponse } from "../utils/apiService";

interface UserListProps {
  data?: DataResponse;
  country: string;
}

export const UserList = ({ data, country }: UserListProps) => {
  return (
    <div>
      {data?.countries.flatMap((c) =>
        c.name === country
          ? c.users.map((u) => <SingleUser key={u.name} user={u} />)
          : []
      )}
    </div>
  );
};
