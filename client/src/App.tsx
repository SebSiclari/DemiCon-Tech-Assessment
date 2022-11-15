import "./App.css";
import { ComboBox } from "./Components/ComboBox";
import { getData } from "./utils/apiService";
import { useState, useEffect } from "react";
import { Country } from "./types/Country";
import { UserList } from "./Components/UserList";
import { Header } from "./Components/Header";

function App() {
  const [data, setData] = useState<{ countries: Country[] }>();
  const [countries, setCountries] = useState<string[]>([]);
  const [country, setCountry] = useState<string>("");

  useEffect(() => {
    (async () => {
      return await getData();
    })()
      .then((response) => {
        setData(response.data);
        setCountries(response.countries);
      })
      .catch(console.error);
  }, []);

  return (
    <>
      <Header />
      <ComboBox
        setCountry={setCountry}
        country={country}
        countries={countries}
      />
      <UserList data={data} country={country} />
    </>
  );
}

export default App;
