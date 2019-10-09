from enum import Enum

NONE = 0
UP = 1
DOWN = 2

up_queue = []
down_queue = []

cur_floor = 0
cur_dir = UP

running = False


def apsort(i, l, rev):
    l.append(i)
    l.sort(reverse=rev)

def add_event(floor, direction):
    if direction == UP:
        if not floor in up_queue:
            apsort(floor, up_queue, 0)
    elif direction == DOWN:
        if not floor in down_queue:
            apsort(floor, down_queue, 1)
    elif direction == NONE:
        if floor > cur_floor and not floor in up_queue:
            apsort(floor, up_queue, 0)
        if floor < cur_floor and not floor in up_queue:
            apsort(floor, down_queue, 1)

def del_event(floor, direction):
    if direction == UP:
        if floor in up_queue:
            for i in range(len(up_queue)):
                if up_queue[i] == floor:
                    return up_queue.pop(i)
        else:# si on monte vers l'élément de la liste descendante
            for j in range(len(down_queue)):
                if down_queue[j] == floor:
                    return down_queue.pop(j)
    if direction == DOWN:
        if floor in down_queue:
            for i in range(len(down_queue)):
                if down_queue[i] == floor:
                    return down_queue.pop(i)
        # si on descend vers l'élément de la liste montante
        else:
            for j in range(len(up_queue)):
                if up_queue[j] == floor:
                    return up_queue.pop(j)

def iter():
    # if cur_dir == UP:
    #     next_ = None
    #     for i in up_queue:
    #         if i > cur_floor:
    #             next_ = i
    #             break
    #     if next_ is None:
    #         if down_queue:
    #             add_event()
    global cur_dir, running, cur_floor

    cur_queue = get_full_queue()
    if running == False:
        if len(cur_queue):    
            running = True
            next_ = cur_queue[0]
            cur_dir = UP if cur_floor < next_ else DOWN
    else:
        next_ = cur_queue[0]
        if cur_floor == next_:
            del_event(cur_floor, cur_dir)
            running = False
        else:
            cur_dir = UP if cur_floor < next_ else DOWN
            cur_floor += 1 if cur_dir == UP else -1
    print(f"elevator floor {cur_floor} direction {'up' if cur_dir == UP else 'down'} running: {running}")



def get_full_queue():
    cur_queue = []
    if cur_dir == UP:
        init = -1
        for i in range(len(up_queue)):
            init = i
            if up_queue[i] >= cur_floor:
                break
        if init >= 0:
            cur_queue += up_queue[init:]
        cur_queue += down_queue
        if init > 0:
            cur_queue += up_queue[:init]
    elif cur_dir == DOWN:
        init = -1
        for i in range(len(down_queue)):
            init = i
            if down_queue[i] <= cur_floor:
                break
        if init >= 0:
            cur_queue += down_queue[init:]
        cur_queue += up_queue
        if init > 0:
            cur_queue += down_queue[:init]
    return cur_queue