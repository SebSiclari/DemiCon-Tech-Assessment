import "./App.css";
import { ComboBox } from "./Components/ComboBox";
import { getData } from "./utils/apiService";
import { useState, useEffect } from "react";
import { User, UserAPI } from "./types/User";
import {Button} from "./Components/Button"
import { UserList } from "./Components/UserList";
import {Header} from './Components/Header'

function App() {
  const [data, setData] = useState<UserAPI>();
  const [countries, setCountries] = useState<string[]>([]);
  const [country, setCountry] = useState<string>("");

  useEffect(() => {
    const fetchData = async () => {
      const apiData = await getData();
      if (apiData) {
        setData(apiData.data);
        setCountries(apiData.countries);
      }
    };

    fetchData();
  }, []);

  useEffect(()=>{
    console.log(country)
  },[country]);

  console.log("data", data);
  console.log("countries", countries);


  return ( <>
  <Header />
  <ComboBox  setCountry={setCountry} country={country} countries={countries} />
  <Button/>
  <UserList data={data} country={country} />
  </>


  )
}

export default App;
