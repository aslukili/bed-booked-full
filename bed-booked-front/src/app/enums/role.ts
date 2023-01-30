export enum Role {
    USER = 1,
    OWNER = 2,
    ADMIN = 3
}

export type FilteredRole = Role.USER | Role.OWNER;

