select
  jt.id
  ,jt.journey_id
  ,jt.title
  ,jt.description
  ,jt.start_date
  ,jt.end_date
from
  t_journey_timeline jt
where
  jt.journey_id= /* journeyId */1