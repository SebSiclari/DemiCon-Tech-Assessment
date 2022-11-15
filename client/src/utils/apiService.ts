import { Country } from "../types/Country";
import { User } from "../types/User";
const BASE_URL = "http://localhost:8080/countries";

export type DataResponse = {
  countries: {
    name: string;
    users: User[];
  }[];
};

export async function getData(): Promise<{
  data: DataResponse;
  countries: string[];
}> {
  const response = await fetch(BASE_URL);
  const result = await response.json();
  const countries = result.countries.map((country: Country) => country.name);
  return {
    data: result,
    countries,
  };
}
