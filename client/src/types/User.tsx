
export interface Country {
  name: string,
  users: User[]
}

export interface UserAPI {
  countries:Country[]
}

export interface User {
  name: string,
  gender:string,
  email:string
}