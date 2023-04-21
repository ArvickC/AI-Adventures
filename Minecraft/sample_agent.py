# A sample *hardcoded* script of a minedojo agent.

import minedojo
#import cv2
#from datetime import datetime as dt
#import get_time as time

w=160
h=256
fps=24
#path=time.getTime()
limit = 200

#out = cv2.VideoWriter(path, cv2.VideoWriter_fourcc(*'mp4v'), fps, (w, h), False)

env = minedojo.make(
        task_id="harvest_milk", 
        image_size=(w, h)
    )

print(f"[TASK] {env.task_prompt}")
#print(f"[GUIDE] {env.task_guidance}")

done = False
count = 0

env.reset()
while (not done and count <= limit):
    action = env.action_space.no_op()
    #randomAction = env.action_space.sample()

    action[0] = 1 # walk forward
    action[2] = 1 # jump

    obs, reward, done, info = env.step(action)
    #out.write(obs['rgb'])
    count += 1

#print("[INFO] Outputted video to " + path)
env.close()