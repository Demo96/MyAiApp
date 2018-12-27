export class SignUpInfo {
    userName: string;
    password: string;
    firstName: string;
    sureName: string;
    phoneNumber: string;
    city: string;
    address: string;
    role: string[];
    
    constructor(userName: string, password: string, firstName: string,
        sureName: string, phoneNumber: string, city: string, address: string) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.sureName = sureName;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.address = address;
        this.role = ['user'];
    }

}
