export class User {

    constructor(private login: string,
                private password: string,
                private id?: number) {}

    get getLogin(): string {
        return this.login;
    }

    get getPassword(): string {
        return this.password;
    }

    get getId(): number {
        return this.id;
    }

}