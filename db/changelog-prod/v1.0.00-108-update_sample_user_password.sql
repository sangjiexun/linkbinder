--liquibase formatted sql
--changeset opentone:v1.0.00-108-update_sample_user_password

--
-- generated by ruby
--  require 'openssl'
--  p OpenSSL::HMAC.hexdigest('sha256', '2016-06-01 00:00:00', 'password')
UPDATE sys_users SET id_created_dt = to_date('2016-06-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS');
UPDATE sys_users SET emp_passwd = '67d1f503ce952f56c10b93e19407ea79b10eff15369029404413383a62ed73f6';
