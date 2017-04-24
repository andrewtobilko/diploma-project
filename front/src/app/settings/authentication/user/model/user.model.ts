export class User {

    constructor(private login: string,
                private password: string) {}

    get getLogin(): string {
        return this.login;
    }

    get getPassword(): string {
        return this.password;
    }

}