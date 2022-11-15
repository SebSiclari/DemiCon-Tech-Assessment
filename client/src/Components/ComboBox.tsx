import React from 'react'

import Combobox from "react-widgets/Combobox";

interface ComboBoxProps {
  countries: string[],
  country: string,
  setCountry: (value: string) => void
}

export const ComboBox = ({countries, country, setCountry}:ComboBoxProps) => {

  // interface for CombBox
return (
  <div id="formBox">
    <Combobox
     id="search"
      defaultValue ="Select Country"
      data={countries}
      value={country}
      onChange={(e)=>{ setCountry(e)}}
    />
    </div>
  )
}

