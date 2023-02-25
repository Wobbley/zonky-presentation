--liquibase formatted sql logicalFilePath:db/changelog/changesets/create-office.sql

--changeset dlozo:create-office

CREATE TABLE "office"
(
    id   uuid NOT NULL DEFAULT gen_random_uuid(),
    name text NOT NULL,
    CONSTRAINT event_uuid_key UNIQUE (id)
);