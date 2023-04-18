# A sample *hardcoded* script of a minedojo agent.

import minedojo

w = 160 # width
h = 256 # height
limit = 200

env = minedojo.make(
        task_id="harvest_milk", 
        image_size=(w, h)
    )

print(f"[TASK] {env.task_prompt}")
#print(f"[GUIDE] {env.task_guidance}")

done = False
count = 0

obs = env.reset()
while (not done and count <= limit):
    action = env.action_space.no_op()

    action[0] = 1 # walk forward
    action[2] = 1 # jump

    obs, reward, done, info = env.step(action)
    count += 1
env.close()