--+up BEGIN
CREATE TABLE IF NOT EXISTS WORKING_SESSIONS
(
  STATE VARCHAR(100) NO NULL,
  PRIMARY KEY (ID)
) INHERITS (BASE_TABLE);

CREATE TRIGGER WS_CREATED BEFORE INSERT ON WORKING_SESSIONS FOR EACH ROW EXECUTE PROCEDURE INIT_TIME_ON_CREATED();
CREATE TRIGGER WS_UPDATED BEFORE UPDATE ON WORKING_SESSIONS FOR EACH ROW EXECUTE PROCEDURE UPDATE_TIME_ON_UPDATED();
--+up END

--+down BEGIN
DROP TRIGGER IF EXISTS WS_CREATED ON WORKING_SESSIONS;
DROP TRIGGER IF EXISTS WS_UPDATED ON WORKING_SESSIONS;

DROP TABLE IF EXISTS WORKING_SESSIONS;
--+down END
