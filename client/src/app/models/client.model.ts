export interface IClient {
  id:             number;
  docType:        string | DocType;
  docNumber:      number;
  firstName:      string;
  lastName:       string;
  city:           string;
  secondName:     string;
  phone:          string;
  secondLastName: string;
  address:        string;
}

export enum DocType {
  "c",
  "p"
}
