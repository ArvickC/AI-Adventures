# used to get time for the video i record in sample_agent.py
from datetime import datetime as dt

def getTime():
    return 'video/'+dt.today().strftime("%m-%d_%H-%M")+'.mp4'

print(getTime())