select
  j.id
  ,j.title
  ,j.description
from
  t_member m
inner join t_journey j
on m.id = j.member_id
where
  m.tmp_login_id= /* tmpLoginId */1