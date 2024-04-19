  import { Person } from "./person.model";

  export class Root{
  id:number;
  person: Person =new Person();
  random: number;
  randomFloat:number;
  bool:string;
  date:string;
  regEx:string;
  enumValue:string;
  elt: string[];

  lastUpdate:string;
  }
