import { Country } from "../types/User";
const BASE_URL = "http://localhost:8080/countries";

export const getData = async () => {
  try {
    const response = await fetch(BASE_URL);
    const result = await response.json();
    // console.log(result);
    const countries = result.countries.map((country: Country) => country.name);
    return {
      data: result,
      countries,
    };
  } catch (e) {
    console.log(e);
  }
};
