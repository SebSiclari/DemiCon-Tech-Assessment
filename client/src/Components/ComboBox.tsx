import React from 'react'

import Combobox from "react-widgets/Combobox";

interface ComboBoxProps {
  countries: string[],
  country: string,
  setCountry: React.Dispatch<React.SetStateAction<string>>
}

export const ComboBox = ({countries, country, setCountry}:ComboBoxProps) => {

  // interface for CombBox
return (
    <Combobox
      defaultValue ="Select Country"
      data={countries}
      value={country}
      onChange={(e)=>{ setCountry(e)}}
    />
  )
}

