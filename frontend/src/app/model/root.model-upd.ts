import { PersonUpdated } from "./person.model-upd";

  export class RootUpdated{
  id:number;
  person: PersonUpdated =new PersonUpdated();
  random: number;
  randomFloat:number;
  bool:string;
  date:string;
  regEx:string;
  enumValue:string;
  elt: string[];

  lastModified:string;
  }
